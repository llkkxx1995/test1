start program : mvn clean compile exec:java -Dexec.mainClass="com.hand.DownLoadPdf" -Dexec.args="...."

Dexec.args="...."  is the location of the file where you want to download,such as C:\\Users\\Hand\\Desktop

mvn clean compile exec:java -Dexec.mainClass="com.hand.DownLoadPdf" -Dexec.args="C:\\Users\\Hand\\Desktop"