package manoj.experiments;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AlphabeticalSorter {

	public static void main(String args[]) throws Exception {
		File f = new File("E:/Car Music/Grooveshark Download");
		HashMap<String, ArrayList<File>> fileMap = new HashMap<String, ArrayList<File>>();
		if (f.isDirectory()) {
			FileFilter filter = new FileFilter() {
				@Override
				public boolean accept(File f) {
					return f.getName().endsWith(".mp3");
				}
			};
			File[] files = f.listFiles(filter);
			Arrays.sort(files);
			for (File file : files) {
				String startChar = file.getName().charAt(0) + "";
				if (fileMap.containsKey(startChar)) {
					ArrayList<File> arrayList = fileMap.get(startChar);
					if (arrayList == null) {
						arrayList = new ArrayList<File>();
					}
					arrayList.add(file);
					fileMap.put(startChar, arrayList);
				} else {
					ArrayList<File> arrayList = new ArrayList<File>();
					arrayList.add(file);
					fileMap.put(startChar, arrayList);
				}
			}
			int count = 0;
			for (String str : fileMap.keySet()) {
				count += fileMap.get(str).size();
				System.out.println(str + " -- "
						+ Arrays.toString(fileMap.get(str).toArray()));
			}

			createFiles(fileMap);
			System.out.println(files.length);
			System.out.println(count);
			System.out.println(Arrays.toString(files));
		}
	}

	private static void createFiles(HashMap<String, ArrayList<File>> fileMap) {

		for (String str : fileMap.keySet()) {

			File f = new File("E:/Car Music/" + str);
			if (!f.exists()) {
				f.mkdir();
				moveFiles(f, fileMap.get(str));
			} else {
				moveFiles(f, fileMap.get(str));
			}
		}

	}

	private static void moveFiles(File f, ArrayList<File> arrayList) {
		for (File file : arrayList) {
			file.renameTo(new File(f.getAbsolutePath() + file.getName()));
		}

	}
}
