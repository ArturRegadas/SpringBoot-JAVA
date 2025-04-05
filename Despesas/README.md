# EndPoints
## Transations
transaction = {

    Long id
    Long senderId
    Long recipientId
    double value
    OffsetDateTime dateTime
}

- [/api/getTransactionsBySender]()
  - Long id
- [/api/getTransactionBySenderGreaterThan]()
  - Long id, double value
- [/api/getTransactionBySenderAndRecipient]()
  - Long senderId, Long recipientId

## User
User = {

    Long id
    String userName
    String password
    double balance
}

- [/api/getUserData]()
  - Long id
- [/api/createUser]()
  - Json UserModel
- [/api/transferMoney]()
  - Json TransactionModel
- [/api/deleteUser]()
  - Long id