#!/bin/sh
RESOURCE_NAME=springboot-demo-0.0.1-SNAPSHOT.jar
 
tpid=`ps -ef|grep $RESOURCE_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
echo 'Kill Process!'
kill -9 $tpid
else
echo 'Stop Success!'
fi
sleep 1

nohup java -jar ./$RESOURCE_NAME >> run.log 2>&1 &
echo Start Success

