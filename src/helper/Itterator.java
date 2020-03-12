package helper;

import java.util.List;

public class Itterator {

	public float[] listToPrimitiveFloatArray(List<Float> floatList) {
		
		float[] floatArray = new float[floatList.size()];
		int index = 0;
		for (Float b : floatList) {
			floatArray[index++] = b;
		}
		return floatArray;
	}
}
