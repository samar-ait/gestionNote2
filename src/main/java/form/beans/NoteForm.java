package form.beans;

import java.util.Vector;
import mod.sco.Note;

public class NoteForm {
	private String num_Ins;
	private Vector<Note> lesNotes;
	
	// Constructor
    public NoteForm() {
        lesNotes = new Vector<Note>();
    }
	public String getNum_Ins() {
		return num_Ins;
	}
	public void setNum_Ins(String num_Ins) {
		this.num_Ins = num_Ins;
	}
	public Vector<Note> getLesNotes() {
		return lesNotes;
	}
	public void setLesNotes(Vector<Note> lesNotes) {
		this.lesNotes = lesNotes;
	}
	

}
