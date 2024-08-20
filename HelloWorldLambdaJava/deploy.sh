#!/bin/bash

mvn package
sam deploy --s3-bucket kjarmicki-lambda --stack-name HelloWorldLambdaJava --capabilities CAPABILITY_IAM
