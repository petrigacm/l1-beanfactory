**bean factory** 

**bean lifecycle**

**lifecycle hooks**

**context overriding** 
- v xml mam jednu bean, v java configu druhu, rovnakeho typu

**autowiring :**
   - constructor
   - setter (optional dependency)
   - @DependsOn
   - @Primary
   - str 110 : autowiring your bean
   - spring stereotypes and differences
   - when use ie injection into @Autowired Set<Object>


@Configuration vs @COmponent - ako funguje cglib pre @Bean anotaciu http://dimafeng.com/2015/08/29/spring-configuration_vs_component/

ukazat circular dependency

autoconfig pre spring boot(optional)

properties, definicia stringu cez @Resource, expression language

i18n, events

**db**

pri tranzakciach ukazat a@transactional, + transactional template + use case - dlho trvajuca operacia blokujuca connection => moze vycerpat connection pool, preto musi beza mimo tranzakcie

full monolithic expense manager

queryDsl

ddl

init script
 
lombok
 
**messageing with spring**

