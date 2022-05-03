import React from "react";
import Paper from "@mui/material/Paper";
import Grid from "@mui/material/Grid";
import TextField from "@mui/material/TextField";
import { Button } from "@mui/material";
import signIn from "../http.js";
import PageHeader from "./PageHeader.jsx";

function SignInForm() {
  const [values, setValues] = React.useState({
    username: "",
    password: "",
  });

  const handleChange = (prop) => (event) => {
    setValues({ ...values, [prop]: event.target.value });
  };

  function handleSubmit() {
    signIn(values);
    setValues({
      ...values,
      username: "",
      password: "",
    });
  }

  return (
    <div>
      <PageHeader message="Sign-in" />
      <Grid
        container
        spacing={0}
        direction="column"
        alignItems="center"
        justifyContent="center"
      >
        <Paper
          elevation={3}
          sx={{ marginY: 3, height: 300, width: 400, alignItems: "center" }}
        >
          <form onSubmit={handleSubmit}>
            <Grid
              container
              spacing={0}
              direction="row"
              alignItems="center"
              justifyContent="center"
              sx={{
                marginTop: 3,
              }}
            >
              <TextField
                id="username-field"
                label="Username"
                variant="outlined"
                type="text"
                autoComplete="username"
                value={values.username}
                onChange={handleChange("username")}
                sx={{ marginX: 1, marginTop: 3 }}
              />
              <TextField
                id="password-field"
                label="Password"
                variant="outlined"
                type="password"
                autoComplete="current-password"
                value={values.password}
                onChange={handleChange("password")}
                sx={{ marginX: 1, my: 3 }}
              />
            </Grid>
            <Grid
              container
              spacing={0}
              direction="row"
              alignItems="center"
              justifyContent="center"
              sx={{
                marginTop: 3,
              }}
            >
              <Button variant="contained" type="submit">
                Submit
              </Button>
            </Grid>
          </form>
        </Paper>
      </Grid>
    </div>
  );
}

export default SignInForm;
