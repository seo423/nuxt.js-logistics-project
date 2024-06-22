import type { UserProperties } from './types'

import { getPublicUrl } from '@/server/utils/getPublicUrl'

interface DB {
  users: UserProperties[]
}

const avatar1 = getPublicUrl('/images/avatars/avatar-1.png')
const avatar2 = getPublicUrl('/images/avatars/avatar-2.png')
const avatar3 = getPublicUrl('/images/avatars/avatar-3.png')
const avatar4 = getPublicUrl('/images/avatars/avatar-4.png')
const avatar5 = getPublicUrl('/images/avatars/avatar-5.png')
const avatar6 = getPublicUrl('/images/avatars/avatar-6.png')

export const db: DB = {
  users: [
    {
      id: 1,
      fullName: 'Galasasen Slixby',
      company: 'Yotz PVT LTD',
      role: 'editor',
      username: 'gslixby0',
      country: 'El Salvador',
      contact: '(479) 232-9151',
      email: 'gslixby0@abc.net.au',
      currentPlan: 'enterprise',
      status: 'inactive',
      avatar: '',
      billing: 'Manual-Credit Card',
    },
    {
      id: 2,
      fullName: 'Halsey Redmore',
      company: 'Skinder PVT LTD',
      role: 'author',
      username: 'hredmore1',
      country: 'Albania',
      contact: '(472) 607-9137',
      email: 'hredmore1@imgur.com',
      currentPlan: 'team',
      status: 'pending',
      avatar: avatar2,
      billing: 'Auto debit',
    },
    {
      id: 3,
      fullName: 'Marjory Sicely',
      company: 'Oozz PVT LTD',
      role: 'maintainer',
      username: 'msicely2',
      country: 'Russia',
      contact: '(321) 264-4599',
      email: 'msicely2@who.int',
      currentPlan: 'enterprise',
      status: 'active',
      avatar: avatar3,
      billing: 'Manual-Credit Card',
    },
    {
      id: 4,
      fullName: 'Cyrill Risby',
      company: 'Oozz PVT LTD',
      role: 'maintainer',
      username: 'crisby3',
      country: 'China',
      contact: '(923) 690-6806',
      email: 'crisby3@wordpress.com',
      currentPlan: 'team',
      status: 'inactive',
      avatar: '',
      billing: 'Auto debit',
    },
    {
      id: 5,
      fullName: 'Maggy Hurran',
      company: 'Aimbo PVT LTD',
      role: 'subscriber',
      username: 'mhurran4',
      country: 'Pakistan',
      contact: '(669) 914-1078',
      email: 'mhurran4@yahoo.co.jp',
      currentPlan: 'enterprise',
      status: 'pending',
      avatar: avatar5,
      billing: 'Manual-Cash',
    },
    {
      id: 6,
      fullName: 'Silvain Halstead',
      company: 'Jaxbean PVT LTD',
      role: 'author',
      username: 'shalstead5',
      country: 'China',
      contact: '(958) 973-3093',
      email: 'shalstead5@shinystat.com',
      currentPlan: 'company',
      status: 'active',
      avatar: '',
      billing: 'Manual-Credit Card',
    },
    {
      id: 7,
      fullName: 'Breena Gallemore',
      company: 'Jazzy PVT LTD',
      role: 'subscriber',
      username: 'bgallemore6',
      country: 'Canada',
      contact: '(825) 977-8152',
      email: 'bgallemore6@boston.com',
      currentPlan: 'company',
      status: 'pending',
      avatar: avatar1,
      billing: 'Manual-PayPal',
    },
    {
      id: 8,
      fullName: 'Kathryne Liger',
      company: 'Pixoboo PVT LTD',
      role: 'author',
      username: 'kliger7',
      country: 'France',
      contact: '(187) 440-0934',
      email: 'kliger7@vinaora.com',
      currentPlan: 'enterprise',
      status: 'pending',
      avatar: '',
      billing: 'Auto debit',
    },
    {
      id: 9,
      fullName: 'Franz Scotfurth',
      company: 'Tekfly PVT LTD',
      role: 'subscriber',
      username: 'fscotfurth8',
      country: 'China',
      contact: '(978) 146-5443',
      email: 'fscotfurth8@dailymotion.com',
      currentPlan: 'team',
      status: 'pending',
      avatar: avatar1,
      billing: 'Manual-Credit Card',
    },
    {
      id: 10,
      fullName: 'Jillene Bellany',
      company: 'Gigashots PVT LTD',
      role: 'maintainer',
      username: 'jbellany9',
      country: 'Jamaica',
      contact: '(589) 284-6732',
      email: 'jbellany9@kickstarter.com',
      currentPlan: 'company',
      status: 'inactive',
      avatar: avatar3,
      billing: 'Manual-Credit Card',
    },
    {
      id: 11,
      fullName: 'Jonah Wharlton',
      company: 'Eare PVT LTD',
      role: 'subscriber',
      username: 'jwharltona',
      country: 'United States',
      contact: '(176) 532-6824',
      email: 'jwharltona@oakley.com',
      currentPlan: 'team',
      status: 'inactive',
      avatar: '',
      billing: 'Manual-Cash',
    },
    {
      id: 12,
      fullName: 'Seth Hallam',
      company: 'Yakitri PVT LTD',
      role: 'subscriber',
      username: 'shallamb',
      country: 'Peru',
      contact: '(234) 464-0600',
      email: 'shallamb@hugedomains.com',
      currentPlan: 'team',
      status: 'pending',
      avatar: avatar3,
      billing: 'Manual-PayPal',
    },
    {
      id: 13,
      fullName: 'Yoko Pottie',
      company: 'Leenti PVT LTD',
      role: 'subscriber',
      username: 'ypottiec',
      country: 'Philippines',
      contact: '(907) 284-5083',
      email: 'ypottiec@privacy.gov.au',
      currentPlan: 'basic',
      status: 'inactive',
      avatar: avatar6,
      billing: 'Manual-PayPal',
    },
    {
      id: 14,
      fullName: 'Maximilianus Krause',
      company: 'Digitube PVT LTD',
      role: 'author',
      username: 'mkraused',
      country: 'Democratic Republic of the Congo',
      contact: '(167) 135-7392',
      email: 'mkraused@stanford.edu',
      currentPlan: 'team',
      status: 'active',
      avatar: '',
      billing: 'Manual-PayPal',
    },
    {
      id: 15,
      fullName: 'Zsazsa McCleverty',
      company: 'Kaymbo PVT LTD',
      role: 'maintainer',
      username: 'zmcclevertye',
      country: 'France',
      contact: '(317) 409-6565',
      email: 'zmcclevertye@soundcloud.com',
      currentPlan: 'enterprise',
      status: 'active',
      avatar: avatar3,
      billing: 'Manual-PayPal',
    },
    {
      id: 16,
      fullName: 'Bentlee Emblin',
      company: 'Yambee PVT LTD',
      role: 'author',
      username: 'bemblinf',
      country: 'Spain',
      contact: '(590) 606-1056',
      email: 'bemblinf@wired.com',
      currentPlan: 'company',
      status: 'active',
      avatar: avatar4,
      billing: 'Manual-PayPal',
    },
    {
      id: 17,
      fullName: 'Brockie Myles',
      company: 'Wikivu PVT LTD',
      role: 'maintainer',
      username: 'bmylesg',
      country: 'Poland',
      contact: '(553) 225-9905',
      email: 'bmylesg@amazon.com',
      currentPlan: 'basic',
      status: 'active',
      avatar: avatar1,
      billing: 'Manual-Credit Card',
    },
    {
      id: 18,
      fullName: 'Bertha Biner',
      company: 'Twinte PVT LTD',
      role: 'editor',
      username: 'bbinerh',
      country: 'Yemen',
      contact: '(901) 916-9287',
      email: 'bbinerh@mozilla.com',
      currentPlan: 'team',
      status: 'active',
      avatar: avatar3,
      billing: 'Manual-Credit Card',
    },
    {
      id: 19,
      fullName: 'Travus Bruntjen',
      company: 'Cogidoo PVT LTD',
      role: 'admin',
      username: 'tbruntjeni',
      country: 'France',
      contact: '(524) 586-6057',
      email: 'tbruntjeni@sitemeter.com',
      currentPlan: 'enterprise',
      status: 'active',
      avatar: '',
      billing: 'Manual-Cash',
    },
    {
      id: 20,
      fullName: 'Wesley Burland',
      company: 'Bubblemix PVT LTD',
      role: 'editor',
      username: 'wburlandj',
      country: 'Honduras',
      contact: '(569) 683-1292',
      email: 'wburlandj@uiuc.edu',
      currentPlan: 'team',
      status: 'inactive',
      avatar: avatar5,
      billing: 'Manual-Cash',
    },
    {
      id: 21,
      fullName: 'Selina Kyle',
      company: 'Wayne Enterprises',
      role: 'admin',
      username: 'catwomen1940',
      country: 'USA',
      contact: '(829) 537-0057',
      email: 'irena.dubrovna@wayne.com',
      currentPlan: 'team',
      status: 'active',
      avatar: '',
      billing: 'Manual-Cash',
    },
    {
      id: 22,
      fullName: 'Jameson Lyster',
      company: 'Quaxo PVT LTD',
      role: 'editor',
      username: 'jlysterl',
      country: 'Ukraine',
      contact: '(593) 624-0222',
      email: 'jlysterl@guardian.co.uk',
      currentPlan: 'company',
      status: 'inactive',
      avatar: avatar6,
      billing: 'Manual-Cash',
    },
    {
      id: 23,
      fullName: 'Kare Skitterel',
      company: 'Ainyx PVT LTD',
      role: 'maintainer',
      username: 'kskitterelm',
      country: 'Poland',
      contact: '(254) 845-4107',
      email: 'kskitterelm@ainyx.com',
      currentPlan: 'basic',
      status: 'pending',
      avatar: avatar2,
      billing: 'Manual-Credit Card',
    },
    {
      id: 24,
      fullName: 'Cleavland Hatherleigh',
      company: 'Flipopia PVT LTD',
      role: 'admin',
      username: 'chatherleighn',
      country: 'Brazil',
      contact: '(700) 783-7498',
      email: 'chatherleighn@washington.edu',
      currentPlan: 'team',
      status: 'pending',
      avatar: '',
      billing: 'Manual-Credit Card',
    },
    {
      id: 25,
      fullName: 'Adeline Micco',
      company: 'Topicware PVT LTD',
      role: 'admin',
      username: 'amiccoo',
      country: 'France',
      contact: '(227) 598-1841',
      email: 'amiccoo@whitehouse.gov',
      currentPlan: 'enterprise',
      status: 'pending',
      avatar: '',
      billing: 'Auto Debit',
    },
    {
      id: 26,
      fullName: 'Hugh Hasson',
      company: 'Skinix PVT LTD',
      role: 'admin',
      username: 'hhassonp',
      country: 'China',
      contact: '(582) 516-1324',
      email: 'hhassonp@bizjournals.com',
      currentPlan: 'basic',
      status: 'inactive',
      avatar: avatar6,
      billing: 'Auto Debit',
    },
    {
      id: 27,
      fullName: 'Germain Jacombs',
      company: 'Youopia PVT LTD',
      role: 'editor',
      username: 'gjacombsq',
      country: 'Zambia',
      contact: '(137) 467-5393',
      email: 'gjacombsq@jigsy.com',
      currentPlan: 'enterprise',
      status: 'active',
      avatar: '',
      billing: 'Auto Debit',
    },
    {
      id: 28,
      fullName: 'Bree Kilday',
      company: 'Jetpulse PVT LTD',
      role: 'maintainer',
      username: 'bkildayr',
      country: 'Portugal',
      contact: '(412) 476-0854',
      email: 'bkildayr@mashable.com',
      currentPlan: 'team',
      status: 'active',
      avatar: '',
      billing: 'Auto Debit',
    },
    {
      id: 29,
      fullName: 'Candice Pinyon',
      company: 'Kare PVT LTD',
      role: 'maintainer',
      username: 'cpinyons',
      country: 'Sweden',
      contact: '(170) 683-1520',
      email: 'cpinyons@behance.net',
      currentPlan: 'team',
      status: 'active',
      avatar: avatar1,
      billing: 'Manual-Cash',
    },
    {
      id: 30,
      fullName: 'Isabel Mallindine',
      company: 'Voomm PVT LTD',
      role: 'subscriber',
      username: 'imallindinet',
      country: 'Slovenia',
      contact: '(332) 803-1983',
      email: 'imallindinet@shinystat.com',
      currentPlan: 'team',
      status: 'pending',
      avatar: avatar5,
      billing: 'Manual-Cash',
    },
    {
      id: 31,
      fullName: 'Gwendolyn Meineken',
      company: 'Oyondu PVT LTD',
      role: 'admin',
      username: 'gmeinekenu',
      country: 'Moldova',
      contact: '(551) 379-7460',
      email: 'gmeinekenu@hc360.com',
      currentPlan: 'basic',
      status: 'pending',
      avatar: avatar2,
      billing: 'Manual-Cash',
    },
    {
      id: 32,
      fullName: 'Rafaellle Snowball',
      company: 'Fivespan PVT LTD',
      role: 'editor',
      username: 'rsnowballv',
      country: 'Philippines',
      contact: '(974) 829-0911',
      email: 'rsnowballv@indiegogo.com',
      currentPlan: 'basic',
      status: 'pending',
      avatar: avatar6,
      billing: 'Manual-Cash',
    },
    {
      id: 33,
      fullName: 'Rochette Emer',
      company: 'Thoughtworks PVT LTD',
      role: 'admin',
      username: 'remerw',
      country: 'North Korea',
      contact: '(841) 889-3339',
      email: 'remerw@blogtalkradio.com',
      currentPlan: 'basic',
      status: 'active',
      avatar: '',
      billing: 'Manual-Cash',
    },
    {
      id: 34,
      fullName: 'Ophelie Fibbens',
      company: 'Jaxbean PVT LTD',
      role: 'subscriber',
      username: 'ofibbensx',
      country: 'Indonesia',
      contact: '(764) 885-7351',
      email: 'ofibbensx@booking.com',
      currentPlan: 'company',
      status: 'active',
      avatar: avatar3,
      billing: 'Manual-Cash',
    },
    {
      id: 35,
      fullName: 'Stephen MacGilfoyle',
      company: 'Browseblab PVT LTD',
      role: 'maintainer',
      username: 'smacgilfoyley',
      country: 'Japan',
      contact: '(350) 589-8520',
      email: 'smacgilfoyley@bigcartel.com',
      currentPlan: 'company',
      status: 'pending',
      avatar: avatar2,
      billing: 'Manual-Cash',
    },
    {
      id: 36,
      fullName: 'Bradan Rosebotham',
      company: 'Agivu PVT LTD',
      role: 'subscriber',
      username: 'brosebothamz',
      country: 'Belarus',
      contact: '(882) 933-2180',
      email: 'brosebothamz@tripadvisor.com',
      currentPlan: 'team',
      status: 'inactive',
      avatar: '',
      billing: 'Manual-Credit Card',
    },
    {
      id: 37,
      fullName: 'Skip Hebblethwaite',
      company: 'Katz PVT LTD',
      role: 'admin',
      username: 'shebblethwaite10',
      country: 'Canada',
      contact: '(610) 343-1024',
      email: 'shebblethwaite10@arizona.edu',
      currentPlan: 'company',
      status: 'inactive',
      avatar: avatar1,
      billing: 'Manual-Credit Card',
    },
    {
      id: 38,
      fullName: 'Moritz Piccard',
      company: 'Twitternation PVT LTD',
      role: 'maintainer',
      username: 'mpiccard11',
      country: 'Croatia',
      contact: '(365) 277-2986',
      email: 'mpiccard11@vimeo.com',
      currentPlan: 'enterprise',
      status: 'inactive',
      avatar: avatar2,
      billing: 'Manual-Credit Card',
    },
    {
      id: 39,
      fullName: 'Tyne Widmore',
      company: 'Yombu PVT LTD',
      role: 'subscriber',
      username: 'twidmore12',
      country: 'Finland',
      contact: '(531) 731-0928',
      email: 'twidmore12@bravesites.com',
      currentPlan: 'team',
      status: 'pending',
      avatar: '',
      billing: 'Auto Debit',
    },
    {
      id: 40,
      fullName: 'Florenza Desporte',
      company: 'Kamba PVT LTD',
      role: 'author',
      username: 'fdesporte13',
      country: 'Ukraine',
      contact: '(312) 104-2638',
      email: 'fdesporte13@omniture.com',
      currentPlan: 'company',
      status: 'active',
      avatar: avatar1,
      billing: 'Auto Debit',
    },
    {
      id: 41,
      fullName: 'Edwina Baldetti',
      company: 'Dazzlesphere PVT LTD',
      role: 'maintainer',
      username: 'ebaldetti14',
      country: 'Haiti',
      contact: '(315) 329-3578',
      email: 'ebaldetti14@theguardian.com',
      currentPlan: 'team',
      status: 'pending',
      avatar: avatar5,
      billing: 'Auto Debit',
    },
    {
      id: 42,
      fullName: 'Benedetto Rossiter',
      company: 'Mybuzz PVT LTD',
      role: 'editor',
      username: 'brossiter15',
      country: 'Indonesia',
      contact: '(323) 175-6741',
      email: 'brossiter15@craigslist.org',
      currentPlan: 'team',
      status: 'inactive',
      avatar: '',
      billing: 'Auto Debit',
    },
    {
      id: 43,
      fullName: 'Micaela McNirlan',
      company: 'Tambee PVT LTD',
      role: 'admin',
      username: 'mmcnirlan16',
      country: 'Indonesia',
      contact: '(242) 952-0916',
      email: 'mmcnirlan16@hc360.com',
      currentPlan: 'basic',
      status: 'inactive',
      avatar: avatar2,
      billing: 'Auto Debit',
    },
    {
      id: 44,
      fullName: 'Vladamir Koschek',
      company: 'Centimia PVT LTD',
      role: 'author',
      username: 'vkoschek17',
      country: 'Guatemala',
      contact: '(531) 758-8335',
      email: 'vkoschek17@abc.net.au',
      currentPlan: 'team',
      status: 'active',
      avatar: avatar1,
      billing: 'Manual-Credit Card',
    },
    {
      id: 45,
      fullName: 'Corrie Perot',
      company: 'Flipopia PVT LTD',
      role: 'subscriber',
      username: 'cperot18',
      country: 'China',
      contact: '(659) 385-6808',
      email: 'cperot18@goo.ne.jp',
      currentPlan: 'team',
      status: 'pending',
      avatar: '',
      billing: 'Manual-Credit Card',
    },
    {
      id: 46,
      fullName: 'Saunder Offner',
      company: 'Skalith PVT LTD',
      role: 'maintainer',
      username: 'soffner19',
      country: 'Poland',
      contact: '(200) 586-2264',
      email: 'soffner19@mac.com',
      currentPlan: 'enterprise',
      status: 'pending',
      avatar: avatar4,
      billing: 'Manual-Credit Card',
    },
    {
      id: 47,
      fullName: 'Karena Courtliff',
      company: 'Feedfire PVT LTD',
      role: 'admin',
      username: 'kcourtliff1a',
      country: 'China',
      contact: '(478) 199-0020',
      email: 'kcourtliff1a@bbc.co.uk',
      currentPlan: 'basic',
      status: 'active',
      avatar: '',
      billing: 'Manual-Credit Card',
    },
    {
      id: 48,
      fullName: 'Onfre Wind',
      company: 'Thoughtmix PVT LTD',
      role: 'admin',
      username: 'owind1b',
      country: 'Ukraine',
      contact: '(344) 262-7270',
      email: 'owind1b@yandex.ru',
      currentPlan: 'basic',
      status: 'pending',
      avatar: avatar3,
      billing: 'Manual-PayPal',
    },
    {
      id: 49,
      fullName: 'Paulie Durber',
      company: 'Babbleblab PVT LTD',
      role: 'subscriber',
      username: 'pdurber1c',
      country: 'Sweden',
      contact: '(694) 676-1275',
      email: 'pdurber1c@gov.uk',
      currentPlan: 'team',
      status: 'inactive',
      avatar: '',
      billing: 'Manual-PayPal',
    },
    {
      id: 50,
      fullName: 'Beverlie Krabbe',
      company: 'Kaymbo PVT LTD',
      role: 'editor',
      username: 'bkrabbe1d',
      country: 'China',
      contact: '(397) 294-5153',
      email: 'bkrabbe1d@home.pl',
      currentPlan: 'company',
      status: 'active',
      avatar: avatar1,
      billing: 'Manual-Cash',
    },
  ],
}
