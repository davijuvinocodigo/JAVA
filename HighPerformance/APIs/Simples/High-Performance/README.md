## Principais Otimizações Implementadas:

````
    CRUD completo com otimizações de performance
    Cache com Caffeine
    Operações assíncronas
    Pool de conexões configurado
    Tratamento de exceções global
    Configurações para alta performance
````

Este exemplo combina várias técnicas para criar uma API de alta performance que pode lidar com um grande número de requisições com baixa latência.



### Criar um produto:
```
curl -X POST -H "Content-Type: application/json" -d '{
    "name": "High Performance Laptop",
    "description": "16GB RAM, 1TB SSD, Intel i9",
    "price": 1999.99,
    "quantity": 100
}' http://localhost:8080/api/v1/products
```

### Obter um produto:
```
curl -X GET http://localhost:8080/api/v1/products/1
```

### Listar todos os produtos (assíncrono):
```
curl -X GET http://localhost:8080/api/v1/products/async
```

### Atualizar um produto:
``` 
curl -X PUT -H "Content-Type: application/json" -d '{
    "name": "High Performance Laptop",
    "description": "16GB RAM, 1TB SSD, Intel i9",
    "price": 1799.99,
    "quantity": 50
}' http://localhost:8080/api/v1/products/1
```

### Deletar um produto:
```
curl -X DELETE http://localhost:8080/api/v1/products/1
```