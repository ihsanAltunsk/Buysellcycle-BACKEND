# Team 03
# Buysellcycle Backend

# DIKKAT EDILMESI GEREKENLER


***GITHUB DA DIKKAT EDILMESI GEREKENLER***
> Projede calismaya baslamadan once mutlaka
>
>      1- main branch'inde "git pull" islemi yapilmalidir
>      2- kendi branch'imize gecip "git merge main" islemi yapilmalidir.

> Github'a ekleme yapilirken kesinlikle **git add .** kullanilmayacak!

***COMMIT ETME ISLEMI***
> **git add src/test/java/pages/US001_002_003_004_005.java** seklinde yapilacak!
>> (class'a sag click > copy path/.. > path from content root) dosya yolu kopyalanir.
>
> **git commit -m "GG.AA.YY/name-2"** (-2 --> gün içinde push etme sayısına göre)
>
> **git push**

***
> -Her islemden once mutlaka main branch'inde olunmadigi kontrol edilmelidir.
>
> -Main branch'inde degisiklik gerekiyorsa lead ile iletisime gecilmeli
***

***ORTAK KULLANILACAK FEATURE STEPLERİ***

- API
> The api user constructs the base url with the "admin" token.  
>
> The api user sets " " path parameters
> 
> The api user verifies that the status code is 201
> 
> The api user verifies that the message information in the response body is " "
> 
> The API user sends a "GET" request and records the response.
> 
> The api user prepares a GETBODY request containing the id = 2 and records the response.
> 
> The api user prepares a DELETEBODY request containing the id = 2 and records the response.
> 
> The api user verifies that updated_Id is same as the param <id>
> 
> The api user verifies that Deleted_Id is same as the request body <id>
> 
> The API user records the response from the api endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.
> 
> The API user confirms the "unauthorizedExceptionMessage".

- DB
> Establish a database connection.
> 
> Close the database connection.
> 
> Process the results for update 1.