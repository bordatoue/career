all: runExample

compile:
	mvn compile

run:
	time java -cp target/classes MinTrianglePath

run500:
	java -cp target/classes/ Gen 500 > data.txt
	cat data.txt | time java -cp target/classes MinTrianglePath

runExample:
	echo 7 > data.txt
	echo 6 3 >> data.txt
	echo 3 8 5 >> data.txt
	echo 11 2 10 9 >> data.txt
	cat data.txt | time java -cp target/classes MinTrianglePath

