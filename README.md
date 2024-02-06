## Please Check

https://medium.com/@fmoraes87/desvendando-o-poder-do-threadlocal-um-guia-pr%C3%A1tico-para-organizar-suas-informa%C3%A7%C3%B5es-de-forma-3aad969ec42a

## Without ThreadLocal

curl --request GET \
--url 'http://localhost:8080/quotation/withoutThreadLocal?currency=US' \
--header 'USER_CURRENT_LOCATION: BRA' \
--header 'USER_ID: 123'

## With ThreadLocal

curl --request GET \
--url 'http://localhost:8080/quotation/withThreadLocal?currency=US' \
--header 'USER_CURRENT_LOCATION: BRA' \
--header 'USER_ID: 123'
