#!/bin/bash

aws lambda invoke --invocation-type RequestResponse --function-name HelloWorldJava --payload {\"a\":\"HelloLambda\"} outputfile.txt
