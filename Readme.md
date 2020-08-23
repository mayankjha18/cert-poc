1. LONGB0642-MBP:test3 mayank$ openssl genrsa -out rootCA.key 4096

2. LONGB0642-MBP:test3 mayank$ openssl req -x509 -new -nodes -key rootCA.key -sha256 -days 1024 -out rootCA.crt

Country Name (2 letter code) []:IN
State or Province Name (full name) []:KA
Locality Name (eg, city) []:Banngalore
Organization Name (eg, company) []:LacalCA
Organizational Unit Name (eg, section) []:LocalCA
Common Name (eg, fully qualified host name) []:LocalCA
Email Address []:someone@abc.com

3. LONGB0642-MBP:test3 mayank$ openssl genrsa -out server.key 2048 
4. LONGB0642-MBP:test3 mayank$ openssl req -new -key server.key -out server.csr  You are about to be asked to enter information that will be incorporated
into your certificate request.
What you are about to enter is what is called a Distinguished Name or a DN.
There are quite a few fields but you can leave some blank
For some fields there will be a default value,
If you enter '.', the field will be left blank.
-----
Country Name (2 letter code) []:IN
State or Province Name (full name) []:KA
Locality Name (eg, city) []:Bangalor
Organization Name (eg, company) []:servercsr
Organizational Unit Name (eg, section) []:servercsr
Common Name (eg, fully qualified host name) []:localhost
Email Address []:someuser@abc.com

Please enter the following 'extra' attributes
to be sent with your certificate request
A challenge password []: 

5. LONGB0642-MBP:test3 mayank$ openssl x509 -req -in server.csr -CA rootCA.crt -CAkey rootCA.key -CAcreateserial -out server.crt -days 1 -sha256


5. LONGB0642-MBP:test2 mayank$ openssl pkcs12 -export -in server.crt -inkey server.key -chain -CAfile rootCA.crt  -out server.p12  
6.  LONGB0642-MBP:test2 mayank$ keytool -importkeystore -deststorepass password -destkeystore server.jks -srckeystore server.p12 -srcstoretype PKCS12




Client Side:
1. Create a jks and add server and rootCA cert to that jks (This will be used for truststore validation)


