OBJS = Controller.class Query.class Timer.class \
	Stack.class Queue.class SinglyLinkedNode.class \
	
.SUFFIXES: .java .class
CC = javac
CFLAGS = -deprecation 

all: $(OBJS)

# Basic dependency
.java.class: 
	$(CC) $(CFLAGS) $<

# Other dependencies
Queue.class: SinglyLinkedNode.class

clean:
	rm -f *.class *~ *#


