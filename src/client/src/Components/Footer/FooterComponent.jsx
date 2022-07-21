import React, {Component} from 'react';
import SimpleReactFooter from "simple-react-footer";

class FooterComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
        }

    }

    componentDidMount() {
    }

    render() {

        const description = "EIST Project 2022 \"Air Pingu\" Flight System by Team Debugging Penguins. Credits to Akshat Tandon, Eben Jowie Haezer, Jonas Arnold, Kilian Burger, Saiyam Jain. Made with React, Java, and <3 ";
        const title = "AirPingu";
        const columns = [
            {
                title: "Resources",
                resources: [
                    {
                        name: "About",
                        link: "/about"
                    },
                    {
                        name: "Careers",
                        link: "/careers"
                    },
                    {
                        name: "Contact",
                        link: "/contact"
                    },
                    {
                        name: "Admin",
                        link: "/admin"
                    }
                ]
            },
            {
                title: "Legal",
                resources: [
                    {
                        name: "Privacy",
                        link: "/privacy"
                    },
                    {
                        name: "Terms",
                        link: "/terms"
                    }
                ]
            },
            {
                title: "Visit",
                resources: [
                    {
                        name: "Locations",
                        link: "/locations"
                    },
                    {
                        name: "Culture",
                        link: "/culture"
                    }
                ]
            }
        ];
        return <SimpleReactFooter
            description={description}
            title={title}
            columns={columns}
            linkedin="linkedin.com"
            facebook="facebook.com"
            twitter="twitter.com"
            instagram="instagram.com"
            youtube="https://www.youtube.com/channel/youtube.com"
            pinterest="fluffy_cats_collections"
            copyright="airpingu"
            iconColor="black"
            backgroundColor="#e5f6fb"
            fontColor="#1f557b"
            copyrightColor="1f557b"
        />;
        /*
        return (
            <footer className="footer">
                EIST Project 2022 | @Team: Debugging Penguins | @Authors: Akshat Tandon, Eben Jowie Haezer, Jonas Arnold, Kilian Burger, Saiyam Jain
            </footer>
        );

         */
    }
}

export default FooterComponent;
