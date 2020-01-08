package pro.smulewicz.audienceversus;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class WSClient extends WebSocketClient {
	public WSClient( final URI serverURI ) {
		super( serverURI );
	}

	@Override
	public void onOpen( final ServerHandshake handshakedata ) {
		System.out.println( "Connection opened." );
		send("Hello, it is me. Mario :)");
	}

	@Override
	public void onMessage( final String message ) {
		System.out.println( "Received: " + message );
	}

	@Override
	public void onClose( final int code, final String reason, final boolean remote ) {
		System.out.println("Connection closed.");
	}

	@Override
	public void onError( final Exception ex ) {
		ex.printStackTrace();
	}
}
