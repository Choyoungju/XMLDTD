package ch14.server;

import java.net.*;
import org.w3c.dom.*;

public abstract class Action {
	public abstract void execute(Socket socket, Document docRequest) throws Exception;
}
