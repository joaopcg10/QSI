JFLAGS =
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        Parser.java \
        Tester.java \
        Menu.java \
        QSI.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class