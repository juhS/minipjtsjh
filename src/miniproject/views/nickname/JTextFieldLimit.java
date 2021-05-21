package miniproject.views.nickname;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument{
	
	private int limit;	//제한할 길이
	
	public JTextFieldLimit(int limit) {	//제한 할 길이를 인자로 받음
		
		this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		
		if(str == null) {
			return;
		}
		
		if(getLength() + str.length() <= limit) {
			super.insertString(offset, str, attr);
		}
	}

}
