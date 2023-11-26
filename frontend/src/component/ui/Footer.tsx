export const Footer = () => {
    return (
        <div className="container">
            <footer className="pt-4 my-md-4 border-top ">
                <div className="row">
                    <div className="col-12 col-md">
                        <i className="bi bi-compass me-2" style={{fontSize: 20}}/>
                        <small className="d-block mb-3 text-muted">© 988 – {new Date().getFullYear()}</small>
                    </div>
                </div>
            </footer>
        </div>
    );
}