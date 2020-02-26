#!/usr/bin/env sh
ROOT="`pwd`"
classes=$ROOT/algs4/build/classes/java
cd "$classes/main"
CLASSPATH=.:$classes/main:$classes/test:$ROOT/algs4/lib/algs4.jar:$CLASSPATH
