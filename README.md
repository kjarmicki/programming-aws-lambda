# Programming AWS Lambda

This repository contains my interactive notes from the Programming AWS Lambda book.

## Notes

1. Lambda can be called synchronously (request/response API call) or asynchronously (triggered by AWS event)
2. It's better to initialize lambda class with heavy instance variables (database connnections etc.) than to re-initialize them every time in the handler as local variables because lambda runtime re-uses instances
