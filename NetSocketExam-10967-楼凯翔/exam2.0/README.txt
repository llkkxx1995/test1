start program : mvn clean compile exec:java -Dexec.mainClass="com.hand.SocketStart" -Dexec.args="a1 a2"

Dexec.args="a1" ServerSocket to provide file path, is the location of the file ,such as C:\\Users\\Hand\\Desktop\\downLoad.pdf

Dexec.args="a2"  is where the location of ClientSocket to put file ,such as C:\\Users\\Hand\\Desktop


mvn clean compile exec:java -Dexec.mainClass="com.hand.SocketStart" -Dexec.args="C:\\Users\\Hand\\Desktop\\downLoad.pdf C:\\Users\\Hand\\Desktop"