Created a data model as under:
```
public class MyDBModel {
    int id;
    String name, contact_no;
}
```
Helper Method for fetching data:
```
    public ArrayList<MyDBModel> fetchData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<MyDBModel> dataList = new ArrayList<>();

        while(cursor.moveToNext())
        {
            MyDBModel model = new MyDBModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.contact_no = cursor.getString(2);
            dataList.add(model);
        }

        return dataList;
    }
```
Logged fetched data:
```
        try {
            MyDBHelper dbHelper = new MyDBHelper(this);
            ArrayList<MyDBModel> data = dbHelper.fetchData();
            for (int i = 0; i < data.size(); i++)
            {
                Log.d("Database Info: ", "ID: " + data.get(i).id + ", Name: " + data.get(i).name + ", Phone Number: " + data.get(i).contact_no);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
```
