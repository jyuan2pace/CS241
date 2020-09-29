OBJS = Keyboard.class Screen.class
.SUFFIXES: .java .class
CC = javac
CFLAGS = -deprecation 

all: $(OBJS)

# Basic dependency
.java.class: 
	$(CC) $(CFLAGS) $<

# Other dependencies

clean:
	rm -f *.class *~ *#


