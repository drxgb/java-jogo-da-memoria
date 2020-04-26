/**
 * InputColunaException
 * <p>Exceção que trata erros de leitura da coluna
 * de um determinado slot</p>
 * 
 * @author Dr.XGB
 * @version 1.0
 */

package exceptions;

public class InputColunaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InputColunaException(String msg) {
		super(msg);
	}

}
