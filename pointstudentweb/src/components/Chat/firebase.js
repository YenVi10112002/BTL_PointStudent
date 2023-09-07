import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getDatabase, ref, push, set, onValue } from 'firebase/database';
import { getAuth } from 'firebase/auth';

const firebaseConfig = {
    apiKey: "AIzaSyDuZucgs6c6UlErIBi4QTWS6yNvkM6EbCo",
    authDomain: "studentapp-7afc7.firebaseapp.com",
    databaseURL: "https://studentapp-7afc7-default-rtdb.firebaseio.com",
    projectId: "studentapp-7afc7",
    storageBucket: "studentapp-7afc7.appspot.com",
    messagingSenderId: "745655172694",
    appId: "1:745655172694:web:3b631a5f66a8280ac645f7",
    measurementId: "G-NQ3725MZ4K"
};

// Initialize Firebase

const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const database = getDatabase(app);
const auth = getAuth(app);


export { database, ref, onValue, push, set, auth };