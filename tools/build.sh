#!/bin/bash

>sources.txt find * -name "*.java"
javac @sources.txt && echo "build completed"
