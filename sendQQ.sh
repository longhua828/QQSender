#! /bin/bash

# $1 is host ip
# $2 is port
# $3 is type 1 is mean send to friend and 2 is mean group 
# $4 is friend name or group name
# $5 is send message

java -classpath QQSender-1.0.0-SNAPSHOT.jar com.violetgo.qqsender.client.MsgClient $1 $2 $3 $4 $5