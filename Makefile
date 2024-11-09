ROOT			:= $(shell dirname $(realpath $(firstword $(MAKEFILE_LIST))))
PROJECT			:= KingdomsVerdict

SRC				:= $(ROOT)/src
BIN				:= $(ROOT)/bin
LIB				:= $(ROOT)/lib
TESTS			:= $(ROOT)/tests

JSRC			:= $(shell find $(SRC) -name "*.java")
JLIB			:= $(subst $(eval ) ,:,$(shell find $(LIB) -name "*.jar"))
JAVAC_FLAGS		:= -d $(BIN) -cp ".:$(JLIB)"
JVM_FLAGS		:= -cp ".:$(BIN):$(JLIB)" --module-path $(BIN)

.ONESHELL:

all: clean build run

clean:
	# rm -rf $(BIN)

build:
	mkdir $(BIN)
	javac $(JAVAC_FLAGS) $(JSRC)

run:
	clear
	@export CLASSPATH=$(BIN):$(LIB):*:.
	@java $(JVM_FLAGS) $(PROJECT) $(ARGS)