import { createSlice } from '@reduxjs/toolkit'

const UserStoreSlice = createSlice({
    name: "UserStore",
    initialState: {
        userDetails: {
            userId: 25000,
            username: 'maggieparker',
            userFirstName: 'Maggie',
            userLastName: 'Parker'
        }
    },
    reducers: {
        setUserDetail: (state, action) => {
            state.userDetails.userId = action.payload.userId;
            state.userDetails.username = action.payload.username;
            state.userDetails.userFirstName = action.payload.userFirstName;
            state.userDetails.userLastName = action.payload.userLastName;

        },
        unsetUserDetail: (state, action) => {
            state.userDetails= {
                userId: 0,
                username: '',
                userFirstName: '',
                userLastName: ''
            }
        }
    }
}
);

export const actions = UserStoreSlice.actions;
export default UserStoreSlice;

