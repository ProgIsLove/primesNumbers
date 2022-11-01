#!/usr/bin/env bash
JAVA_PROGRAM_ARGS=`echo "$@"`
export JAVA_PROGRAM_ARGS
mvn clean install
mvn exec:java -Dexec.mainClass="Main" -Dexec.args="$JAVA_PROGRAM_ARGS"
$SHELL
