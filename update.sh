#!/bin/sh

if [ -d "/out" ] && [ -d "/plugin" ]; then
	cp src/py/*.py .
	mkdir -p /plugin/lib/frontend && rm /plugin/lib/frontend/*
	cp /out/bin/frontend/* /plugin/lib/frontend/
	rm -rf /out/bin/frontend
	echo "Patching stupid varargs because varargs in kotlin js are jank"
	sed -i 's/(args: Array/(...args: Array/g' /plugin/lib/frontend/*-frontend.d.ts
	sed -i 's/ = function (args)/ = function (...args)/g' /plugin/lib/frontend/yasdpl-frontend.js
else
	sudo cp src/py/*.py .
	sudo mkdir -p ./lib/frontend && sudo rm ./lib/frontend/*
	cd ./backend || exit
	sudo find ./build -user root -exec sudo chown "$(id -u):$(id -g)" {} +
	 ./gradlew kotlinUpgradeYarnLock build --refresh-dependencies
	sudo cp ./build/dist/frontend/productionLibrary/* ../lib/frontend/
	cd .. || exit
	echo "Patching stupid varargs because varargs in kotlin js are jank"
	sudo sed -i 's/(args: Array/(...args: Array/g' ./lib/frontend/*-frontend.d.ts
	sudo sed -i 's/ = function (args)/ = function (...args)/g' ./lib/frontend/yasdpl-frontend.js
fi