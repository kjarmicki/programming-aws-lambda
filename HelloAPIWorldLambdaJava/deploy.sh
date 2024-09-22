#!/bin/bash

mvn package
sam deploy --s3-bucket kjarmicki-lambda --stack-name HelloApiWorldLambdaJava --capabilities CAPABILITY_IAM
