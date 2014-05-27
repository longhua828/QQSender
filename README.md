aster##QQSender

you can send Q message by QQSender.

when you send message,you can choose Q-group or you Q-friends

##Quick-Start

1.build by source

	mvn clean package

2.set your QQ number and password in qqserver.properties
	
	# log4j config file location
	log4j = log4j.properties
	
	# qq number
	qq = 2257510634
	
	# password
	password = xxxxxx
	
	# thrift PORT
	port = 7176

3.start QQ Server

	java -jar QQSender.jar

4.send message by shell sendQQ.sh 

	# $1 is host ip
	# $2 is port
	# $3 is type 1 is mean send to friend and 2 is mean group 
	# $4 is friend name or group name
	# $5 is send message



