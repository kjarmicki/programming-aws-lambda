#!/bin/bash

aws lambda invoke --invocation-type RequestResponse --function-name HelloApiWorldJava --payload {\"a\":\"HelloLambda\"} outputfile.txt
