#!/bin/bash
echo "Building bot $1"

propfile="src/org/rsjug/telegram/bot/telegram.properties"

echo $propfile

if [ -f "$2/ant" ]
then
        echo ".... check: ant found"
else
        echo ".... ant not found at $2"
        exit 1
fi

if [ -f "$propfile.$1" ]
then
	echo ".... check: telegram.properties.$1 found."
        cp "$propfile.$1" "$propfile"
        echo ".... properties file copied" 
        $2/ant -f rsbotbuild.xml
        echo ".... build complete"
        cp out/rsjugbot-prod.jar $3/rsjugbot-prod.jar
        echo ".... rsjugbot-prod.jar copied to export folder"
else
	echo "telegram.properties.$1 not found. Check bot config"
        exit 1
fi
