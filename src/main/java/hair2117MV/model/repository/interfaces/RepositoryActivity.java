package hair2117MV.model.repository.interfaces;

import hair2117MV.model.base.Activity;

import java.util.Date;
import java.util.List;

public interface RepositoryActivity {

	List<Activity> getActivities();
	boolean addActivity(Activity activity);
	boolean removeActivity(Activity activity);
	boolean saveActivities();
	int count();
	List<Activity> activitiesByName(String name);
	List<Activity> activitiesOnDate(String name, Date d);
	
}
