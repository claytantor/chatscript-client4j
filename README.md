# chatscript-client4j
a simple java client for chatscript server. This is a very simple Java client for 
chatscript. It is intended to be used with a chatscript server ie. 
https://hub.docker.com/r/claytantor/chatscript-docker/

## Building
`./gradlew clean build shadowJar`

# Using the Client
The Java client is easily embedded into any java applicayion.

```
String hostName = args[0];
int portNumber = Integer.parseInt(args[1]);
String user = args[2];
String robotName = args[3];

//make the client
ChatScriptClient client = new ChatScriptClient(hostName,portNumber,user,robotName);

```

Each client call returns a specific response:

```
String input = "How are you today Harry?";
System.out.println("Harry: " + client.send(input));
```


# Using the App
```
java -jar ./build/libs/chatscript-client4j-0.3.3-all.jar localhost 1024 Clay Harry
Lets start chatting Clay!
>what do you want?
Clay: what do you want?
Harry: I don't actually want anything.
>I want something.
Clay: I want something.
Harry: Indeed.
>.
done.
```
