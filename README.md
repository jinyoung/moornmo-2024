# 

## Model
www.msaez.io/#/487999/storming/moornmo

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- sales
- production
- dashboard
- master


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- master
```
 http :8088/companies id="MRM" name="murunmo" 
 http :8088/users id="rickie@murunmo.com" email="email" name="rickie" addresses[0][city]="seoul" addresses[0][street]="garosugil" addresses[1][city]="yongin" addresses[1][street]="masungro"
 http :8088/items id="ITEM1" name="ITEM1" 
```

- sales
  - Validation:
```
 http :8088/sales itemId[id]="ITEM1" qty=10 

 # will returns following error:

{
    "error": "Bad Request",
    "message": "Some mandatory entry value is not present",
    "path": "/sales",
    "status": 400,
    "timestamp": "2024-05-31T12:06:15.934+00:00"
}
```

   - Correction:
```
http :8088/sales companyId[id]="MRM" itemId[id]="ITEM1" qty=10 

# will returns 200 OK:

HTTP/1.1 201 Created
Content-Type: application/json
Date: Fri, 31 May 2024 12:11:06 GMT
Location: http://localhost:8082/sales/2
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
transfer-encoding: chunked

{
    "_links": {
        "sales": {
            "href": "http://localhost:8082/sales/2"
        },
        "self": {
            "href": "http://localhost:8082/sales/2"
        }
    },
    "companyId": {
        "id": "MRM",
        "name": null
    },
    "itemId": {
        "id": "ITEM1",
        "name": null
    },
    "qty": 10,
    "status": null
}

```


- production
```
 http :8088/productions

 #will returns a production item that corresponds to the orderItem:

 {
    "_embedded": {
        "productions": [
            {
                "_links": {
                    "complete-production": {
                        "href": "http://localhost:8083/productions/1/complete-production"
                    },
                    "production": {
                        "href": "http://localhost:8083/productions/1"
                    },
                    "self": {
                        "href": "http://localhost:8083/productions/1"
                    }
                },
                "orderId": 2,
                "productId": "ITEM1",
                "qty": 10
            }
        ]
    },
    "_links": {
        "profile": {
            "href": "http://localhost:8083/profile/productions"
        },
        "self": {
            "href": "http://localhost:8083/productions"
        }
    },
    "page": {
        "number": 0,
        "size": 20,
        "totalElements": 1,
        "totalPages": 1
    }
}

 http PUT :8088/productions/1/completeproduction
```

- check the order status:
```
 http :8088/sales/1

 #will returns its status as null:
    "_embedded": {
        "sales": [
            {
                "_links": {
                    "sales": {
                        "href": "http://localhost:8082/sales/2"
                    },
                    "self": {
                        "href": "http://localhost:8082/sales/2"
                    }
                },
                "companyId": {
                    "id": "MRM",
                    "name": null
                },
                "itemId": {
                    "id": "ITEM1",
                    "name": null
                },
                "qty": 10,
                "status": null
            }
        ]
    },
```

- Complete the Production:
```
 http PUT :8088/productions/1/complete-production

```

- check again for the order status:
```
 http :8088/sales

 #will returns its status as "DELIVERED":
       "sales": [
            {
                "_links": {
                    "sales": {
                        "href": "http://localhost:8082/sales/2"
                    },
                    "self": {
                        "href": "http://localhost:8082/sales/2"
                    }
                },
                "companyId": {
                    "id": "MRM",
                    "name": null
                },
                "itemId": {
                    "id": "ITEM1",
                    "name": null
                },
                "qty": 10,
                "status": "DELIVERED"
            }
        ]
```

- You can watch the dashboard its statuses are changing according to the Sales and Production stages proceed
```

http :8088/dashboards

# will returns:
{
    "_embedded": {
        "dashboards": [
            {
                "_links": {
                    "dashboard": {
                        "href": "http://localhost:8084/dashboards/2"
                    },
                    "self": {
                        "href": "http://localhost:8084/dashboards/2"
                    }
                },
                "customerId": "MRM",
                "productionStatus": "COMPLETED",  <==
                "salesStatus": "INIT"
            }
        ]
    },

```

- Check the Kafka messages:

1. attach to the container instance:
```
cd infra
docker-compose exec -it kafka /bin/bash
```
2. watch kafka event by pushing this command:
```
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic moornmo --from-beginning

# will shows these event logs:
{"eventType":"SalesRegistered","timestamp":1717157466415,"id":2,"companyId":"MRM","productId":"ITEM1","qty":10,"customerId":null}
{"eventType":"ProductionScheduled","timestamp":1717157466938,"id":1,"productId":"ITEM1","qty":10,"orderId":2}
{"eventType":"ProductionCompleted","timestamp":1717157772323,"id":1,"productId":"ITEM1","qty":10,"orderId":2}
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

