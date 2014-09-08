#!/usr/bin/sh

if [ $# -ne 1 ]; then
    echo "使い方: sh development-exec.sh <LWJGFont のバージョン>"
    echo "  詳細は README.md を参照のこと"
    exit 1
fi

#VERSION=1.1-SNAPSHOT
VERSION=$1

java -jar ~/.m2/repository/net/chocolapod/lwjgfont/${VERSION}/lwjgfont-${VERSION}.jar -x
java -jar ~/.m2/repository/net/chocolapod/lwjgfont/${VERSION}/lwjgfont-${VERSION}.jar \
    ../materials/migu-1p-regular.ttf:28 \
    ../materials/migu-1p-regular.ttf:45 \
    ../materials/TKaisho-GT01.ttc:32 \
    ../materials/DragonQuestFC.ttf:28 \
    "VLGothic@VL ゴシック:12"

if [ $? -ne 0 ]; then
    echo 'フォントの変換に失敗しました'
fi

mvn install:install-file -Dfile=example_demo-1.0.jar -DpomFile=example_demo-1.0.pom.xml -DgroupId=net.chocolapod.lwjgfont -DartifactId=example_demo -Dversion=1.0 -Dpackaging=jar

