
# Separação em camadas para distribuir as reponsabilidades de cada uma delas:
- Repository: Camada de acesso aos dados do banco de dados
- Service: camada para separar as regras de negócios e validações
- Controller: camada para expor os serviços para o mundo externo
- Entity: Tabelas do banco de dados
- DTO: classes para definir os campos de Request e Response