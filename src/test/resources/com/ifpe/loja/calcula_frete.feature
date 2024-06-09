# language: pt
Funcionalidade: Calcular frete

  Cenario: Frete gratuito quando o produto for comprado na mesma cidade sede da loja
    Dado a cidade sede da loja
    E o mesmo estado da sede
    E o valor da compra for 27
    Quando for calculado o frete
    Então não deve pagar frete

  Cenario: Quando for informado a cidade como sede não pode permitir informar um estado que não seja o mesmo da cidade sede
    Dado a cidade sede da loja
    E um estado diferente da sede
    E o valor da compra for 100
    Quando for calculado o frete
    Então uma exceção deve ser lançada com a mensagem "Cidade sede tem que está no estado sede"

  Cenario: Não é permitido o valor da compra negativo
    Dado a cidade sede da loja
    E o mesmo estado da sede
    E o valor da compra for -50
    Quando for calculado o frete
    Então uma exceção deve ser lançada com a mensagem "Valor da compra não pode ser negativo"

  Cenario: Frete gratuito para o mesmo estado da sede e o valor da compra for acima de 200
    Dado uma cidade que não seja a sede da loja
    E o mesmo estado da sede
    E o valor da compra for 250
    Quando for calculado o frete
    Então não deve pagar frete

  Cenario: Quando a compra for feita em outro estado deve pagar frete
    Dado uma cidade que não seja a sede da loja
    E um estado diferente da sede
    E o valor da compra for 50
    Quando for calculado o frete
    Então deve pagar frete

  Cenario: Deve pagar frete se a compra for feita no mesmo estado da sede mas o valor for abaixo de 200
    Dado uma cidade que não seja a sede da loja
    E o mesmo estado da sede
    E o valor da compra for 100
    Quando for calculado o frete
    Então deve pagar frete
