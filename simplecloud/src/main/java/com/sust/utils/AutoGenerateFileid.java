package tzw.sust.utils;

/**
 * @author TianZhengwei
 * @date 2020/04/17 12:34
 * @description
 */
public class AutoGenerateFileid {
	private static int fileid = 1;

	public int getFileid_auto() {
		fileid++;
		return fileid;
	}
}
