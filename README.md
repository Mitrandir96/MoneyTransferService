Команда запуска: docker-compose up

front доступен по ссылке: http://localhost:3000/card-transfer
back доступен по ссылке: http://localhost:5500/transfer, http://localhost:5500/confirmOperation

Примеры запросов:

POST /transfer 
```json
{
  "cardFromNumber": "123222222222222222223",
  "cardFromValidTill": "2326",
  "cardFromCVV": "1112222222222222222222",
  "cardToNumber": "112222222222222222222",
  "amount": {
    "value": 1,
    "currency": "111"
  }
}
```

POST /confirmOperation
```json
{
  "operationId": "1",
  "code": "1234"
}
```

