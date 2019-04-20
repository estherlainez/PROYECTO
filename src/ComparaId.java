import java.util.Comparator;

public class ComparaId implements Comparator<Agenda>{
		
		@Override
		public int compare(Agenda a1, Agenda a2) {
			Agenda Ob1 = (Agenda)a1;
			Agenda Ob2 = (Agenda)a2;
			if(Ob1.getId()<Ob2.getId())return -1;
			if(Ob1.getId()>Ob2.getId())return 1;
			return 0;
		}
}

