#!/bin/bash
set -e
eval "$( fixuid )"
cd /backend
mkdir -p ./.cache
[ -d "./.cache/.gradle" ] && cp -r ./.cache/.gradle "$HOME"/
#[ -d "./.cache/.konan" ] && cp -r ./.cache/.konan /root/
#./gradlew kotlinUpgradeYarnLock build --refresh-dependencies
#sudo chown -R "$(id -u):$(id -g)" $HOME/graalvm
./gradlew kotlinUpgradeYarnLock build nativeCompile --refresh-dependencies
sudo mkdir -p ./out
#cp ./build/bin/backend/backendReleaseExecutable/backend.kexe ./out/backend
sudo cp ./build/native/nativeCompile/backend ./out/backend
[ "$RELEASE_TYPE" == "development" ] && sudo cp ./build/libs/backend.jar ./out/backend.jar
[ -d "$HOME/.gradle" ] && cp -r "$HOME/.gradle" ./.cache/
#[ -d "/root/.konan" ] && cp -r /root/.konan ./.cache/
#ldd ./out/backend
#echo "Fixing link data for SteamOS"
#patchelf --replace-needed libcrypt.so.1 libcrypt.so.2 ./out/backend
#ldd ./out/backend
echo "Copying js files over for frontend"
sudo mkdir -p ./out/frontend
sudo cp ./build/dist/frontend/productionLibrary/* ./out/frontend/
[ "$RELEASE_TYPE" == "development" ] && sudo cp -r "$JAVA_HONE" ./out/jvm
sudo chown -R "$(id -u):$(id -g)" ./out