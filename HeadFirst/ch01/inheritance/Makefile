.PHONY: clean %.class                                                                                                                                                      

CFLAGS = -classpath ".:/home/yang/programming/algs4ed/algs4.jar:/home/yang/programming/algs4ed/stdlib.jar"

all : Duck MallardDuck RedheadDuck RubberDuck

Duck : Duck.class

MallardDuck : MallardDuck.class

RedheadDuck : RedheadDuck.class

RubberDuck : RubberDuck.class

%.class : %.java
	export CLASSPATH=".:/home/yang/programming/algs4ed/algs4.jar:/home/yang/programming/algs4ed/stdlib.jar"
	javac $(CFLAGS) $<

clean:
	rm -rf *.class
