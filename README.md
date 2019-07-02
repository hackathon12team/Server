# Server

## Access
You can get access to heat backend by url: [https://heat-backend.herokuapp.com](https://heat-backend.herokuapp.com/).

## Methods
- */registration*

Allows you to register a new user.

**Input format**
```
{
  "gender": "FEMALE",
  "birthDate": 944956800000,
  "weight": 54,
  "height": 170,
  "physicalActivity": 1.4,
  "targetWeight": 52
}
```

**Output format**
```
{
  "userId": 12,
  "username": null,
  "email": null,
  "userSettings": {
    "gender": "FEMALE",
    "birthDate": 944956800000,
    "weight": 54,
    "height": 170,
    "physicalActivity": 1.4,
    "targetWeight": 52
  },
  "password": "��:{X�R�L�u`:�|�"
}
```
