package javap;


interface Savable {
    public void Save(Saver save,String TAG);
    public void Read(SaveReader read,String TAG);
}
